# winter-properties
[winter-properties](https://github.com/thewinterframework/properties) is a Gradle plugin that allows generate the **plugin.yml** <br>
from the gradle **buildscript** or **gradle.properties** file <br>

### Examples
You can generate the plugin.yml file from the buildscript or the gradle.properties file

#### Using buildscript
Adding pluginProperties extension to buildscript:
```groovy
pluginProperties {
    name = 'MyPlugin'
    version = '1.0.0'
    main = 'com.github.myname.MyPluginClass'
    author = 'MyName'
    description = 'My first amazing plugin using winter-properties!'
}
```

#### Using gradle.properties
Using prefix *spigot* before the property, and use "," for line separators in lists
```properties
spigot.name=MyPlugin
spigot.apiVersion=1.13
spigot.description=My first amazing plugin using winter-properties!
spigot.authors=Me,MyFriend
spigot.version=1.0.0
spigot.main=com.github.myname.MyPluginClass
```

#### NOTE
If you have both methods for plugin.yml serialization, the gradle extension will be used by default

### Available properties
Since winterframework has an internal command manager, the command and permission properties are not available in this gradle plugin <br>
See all available properties (except those mentioned above) [here](https://www.spigotmc.org/wiki/plugin-yml/)

### Installation
Adding to your gradle buildscript
```kotlin
plugins {
    id 'io.winter.properties' version '2.0'
}
```
