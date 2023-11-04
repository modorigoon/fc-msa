.PHONY: run

run:
	@echo "Running ./gradlew jibDockerBuild"
	@./gradlew jibDockerBuild
	@echo "Running docker-compose up -d"
	@docker-compose up -d
