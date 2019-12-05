# java_SandBox_cfa
Sandbox for some Java project during cfa formation.
https://esling.github.io/teaching-java/


## Intellij projects
- welcome_to_the_jogl
- pokédeck

## Compile & execute

<pre>
./compile.py --path <i>project</i> <i>arguments</i>
</pre>

## Compile manually

<pre>
<b><i>project</i>/src/<i>package_name</i>$</b> javac -d ../../class *.java
</pre>

For example :

<pre>
<b>bataille/src/bataille$</b> javac -d ../../class *.java
</pre>

## Execute manually

<pre>
<b><i>project</i>/class$</b> java <i>package_name</i>.<i>main_class</i>
</pre>

For example :

<pre>
<b>bataille/class$</b> java bataille.Bataille 
</pre>
