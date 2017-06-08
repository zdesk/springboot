<H2>Spring boot with Swagger 2</H2>

<p>To create a sprint boot deployable in apache -</P>

* Extend your applicaiton class with SpringBootServletInitializer
    * override configure method

* Add war packaging to pom.xml

* Add below dependency to pom.xml
        <p>
			'''
				<dependency>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-tomcat</artifactId>
					<scope>provided</scope>
				</dependency>
			'''
		</p>

* add a property to pom.xml
    *   <p>
			'''
				<properties>
					<start-class>yourpackage.startapplicaitonclass</start-class>
				</properties>
			'''
		</P>
