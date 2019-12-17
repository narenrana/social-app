#Go to social app project and run this

mvn clean install -Dmaven.test.skip=true

docker build --build-arg  JAR_FILE=target/*.jar -t spgroup-sample .

docker run -p 80:8080 spgroup-sample



