#Go to social app project and run this

mvn clean install

docker build --build-arg  JAR_FILE=target/*.jar -t spgroup-sample .

docker run -p 8080:8080 spgroup-sample



