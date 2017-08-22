# GiveMeMC [![](https://jitpack.io/v/JoeZwet/GiveMeMC.svg)](https://jitpack.io/#JoeZwet/GiveMeMC)
Java implementation of the Minecraft api provided by [Yive](https://github.com/Yive) on [GameAPIs.net](https://gameapis.net/).

## Download
You can download **GMMC** using **Maven** or **Gradle** via [JitPack.io](https://jitpack.io/#JoeZwet/GiveMeMC).

Maven:
```xml
<repositories>
  ...
	<repository>
		 <id>jitpack.io</id>
		 <url>https://jitpack.io</url>
	</repository>
  ...
</repositories>
```
```xml
<dependencies>
  ...
  	<dependency>
	    <groupId>com.github.JoeZwet</groupId>
	    <artifactId>GiveMeMC</artifactId>
	    <version>v1.0.0-SNAPSHOT</version>
	  </dependency>
  ...
</dependencies>
```

Gradle:
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
```
dependencies {
	compile 'com.github.JoeZwet:GiveMeMC:v1.0.0-SNAPSHOT'
}
```

## Examples
Examples can be found in the examples folder located [here](https://github.com/JoeZwet/GiveMeMC/tree/master/src/main/java/examples)!
**NOTE:** The **getExtensiveInfo.jar** example requires the server to have **enable-query** set to **true** in it's **server.properties** (**config.yml** for BungeeCord servers).
