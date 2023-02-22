javac -classpath .:./jars/*:target/dependency/* -d . $(find . -type f -name '*.java')
java -classpath .:./jars/*:target/dependency/* BookStoreTest
