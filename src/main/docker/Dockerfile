#FROM java:8
FROM jeanblanchard/busybox-java:jdk8
MAINTAINER José Moreno (https://github.com/jomoespe)
ADD challenge.war /
ENTRYPOINT ["java", "-jar", "/challenge.war"]