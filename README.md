# primenumbers

Rest service that calculates the prime numbers to given limit

## Installation
Clone the repo.
Setup your JAVA_HOME.
Build the project using maven (mvn package).
Setup PrimeNumbersApplication.java as a Java Application - set server as a program argument(server config.yml if you want to use config.yml as a config)
Run PrimeNumbersApplication.java as a Java Application()
Go to http://localhost:port/primenumbers?limit=10&algorithm=1

port - 8080 by default, configurable if you are using config.yml
limit - calculates the prime numbers to this given limit
algorithm - which algorithm to use (1 or 2)
