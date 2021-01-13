package com.roytuts.jpa.persistence.unit.java.xml.config;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.roytuts.jpa.persistence.unit.java.xml.config.entity.User;

public class PersistenceUnitConfig {

	private static EntityManager entityManager;

	public static EntityManager getEntityManager() {

		if (entityManager == null) {
			// XML based config
			// final EntityManagerFactory factory = //
			// Persistence.createEntityManagerFactory("jpaPersistanceUnit");

			// Java based config
			final EntityManagerFactory factory = new HibernatePersistenceProvider()
					.createContainerEntityManagerFactory(persistenceUnitInfo(), properties());

			return factory.createEntityManager();
		}

		return entityManager;

	}

	private static Properties properties() {
		final Properties properties = new Properties();

		properties.put("javax.persistence.provider", "org.hibernate.jpa.HibernatePersistenceProvider");
		properties.put("javax.persistence.transactionType", "RESOURCE_LOCAL");

		properties.put("dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
		properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/roytuts");
		properties.put("javax.persistence.jdbc.user", "root");
		properties.put("javax.persistence.jdbc.password", "root");

		// properties.put("hibernate.cache.use_second_level_cache", "true");
		// properties.put("hibernate.cache.use_query_cache", "true");

		properties.put("hibernate.transaction.flush_before_completion", "true");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");

		return properties;
	}

	private static PersistenceUnitInfo persistenceUnitInfo() {
		return new PersistenceUnitInfo() {
			@Override
			public String getPersistenceUnitName() {
				return "jpaPersistenceUnit";
			}

			@Override
			public String getPersistenceProviderClassName() {
				return HibernatePersistenceProvider.class.getName();
			}

			@Override
			public PersistenceUnitTransactionType getTransactionType() {
				return PersistenceUnitTransactionType.RESOURCE_LOCAL;
			}

			@Override
			public DataSource getJtaDataSource() {
				return null;
			}

			@Override
			public DataSource getNonJtaDataSource() {
				return null;
			}

			@Override
			public List<String> getMappingFileNames() {
				return Collections.emptyList();
			}

			@Override
			public List<URL> getJarFileUrls() {
				try {
					return Collections.list(this.getClass().getClassLoader().getResources(""));
				} catch (IOException e) {
					throw new UncheckedIOException(e);
				}
			}

			@Override
			public URL getPersistenceUnitRootUrl() {
				return null;
			}

			@Override
			public List<String> getManagedClassNames() {
				Class<?>[] classes = new Class<?>[] { User.class };

				return Arrays.asList(classes).stream().map(Class::getName).collect(Collectors.toList());
			}

			@Override
			public boolean excludeUnlistedClasses() {
				return false;
			}

			@Override
			public SharedCacheMode getSharedCacheMode() {
				return SharedCacheMode.UNSPECIFIED;
			}

			@Override
			public ValidationMode getValidationMode() {
				return ValidationMode.AUTO;
			}

			@Override
			public Properties getProperties() {
				return properties();
			}

			@Override
			public String getPersistenceXMLSchemaVersion() {
				return "2.2";
			}

			@Override
			public ClassLoader getClassLoader() {
				return Thread.currentThread().getContextClassLoader();
			}

			@Override
			public void addTransformer(ClassTransformer transformer) {

			}

			@Override
			public ClassLoader getNewTempClassLoader() {
				return null;
			}
		};
	}

}
