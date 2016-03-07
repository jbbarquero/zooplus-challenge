FROM jeanblanchard/busybox-java:jdk8
MAINTAINER José Moreno (https://github.com/jomoespe)
ADD target/challenge.war keystore.p12 /
ENTRYPOINT ["java", "-jar", "/challenge.war"]