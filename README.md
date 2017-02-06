# Arquillian

Arquillian tests for java ee 7 services.

Clone this repo into new project folder (e.g., `arquillian`).
```bash
git clone  https://github.com/kinfall/arquillian
cd arquillian
```
Run maven command for target/arquillian.jar generate. Use -P profile parameter (e.g, `arquillian-weld-ee-embedded` for generete service for weld-ee-embedded container test.

```bash
mvn clean install package -P arquillian-weld-ee-embedded
```

## Next Release 1.0.1x

Working to inprove and delivere new services:

* `profiles` - include new container for testing, like wildfly embedded.
* `services` - include more complex services using CDI features.
* `jpa` 	 - include persistence, in memory, jpa service for arquillian test.
