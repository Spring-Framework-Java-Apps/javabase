# defcon :: documentation

## JBake
* [https://jbake.org/]

## jbake-maven-plugin
* [https://github.com/jbake-org/jbake-maven-plugin]

## Goals

There are 4 goals provided by this plugin:

* ```jbake:seed```     - seeds your project/site with example content and templates
* ```jbake:generate``` - bakes your project/site
* ```jbake:watch```    - watches to changes and bakes your site whenever a change is detected
* ```jbake:inline```   - bakes, watches and serves out content on [http://localhost:8080]

## Help on Goals

You can also more details on each goal by running the help goal:


    $ mvn jbake:help -Ddetail # -DgoalName=[seed|generate|watch|inline]


[http://localhost:8080]:http://localhost:8080 (defcon :: documentation by jbake)
[https://jbake.org/]:https://jbake.org/ (jbake)
[https://github.com/jbake-org/jbake-maven-plugin]:https://github.com/jbake-org/jbake-maven-plugin (jbake maven plugin on github)