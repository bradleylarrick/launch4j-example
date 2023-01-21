# launch4j-maven-plugin example project

This project demonstrates the problem created by the launch4j-maven-plugin when generating the
project site.

## My Environment

* Windows 10 Pro
* JDK 19
* Maven v3.8.7

## Building the project

```bash
mvn clean verify site
```

The resulting site will include Plugin Management and Plugins pages in which the
GroupId, ArtifactId and Version columns are all filled with the values for this project,
not the actual plugins.

<section>
<h2><a name="Project_Build_Plugins"></a>Project Build Plugins</h2><a name="Project_Build_Plugins"></a>
<table border="0" class="table table-striped">
<tr class="a">
<th>GroupId</th>
<th>ArtifactId</th>
<th>Version</th></tr>
<tr class="b">
<td align="left">org.natuna</td>
<td>launch4j-example</td>
<td>0.0.1</td></tr>
<tr class="a">
<td align="left">org.natuna</td>
<td>launch4j-example</td>
<td>0.0.1</td></tr>
<tr class="b">
<td align="left">org.natuna</td>
<td>launch4j-example</td>
<td>0.0.1</td></tr>
<tr class="a">
<td align="left">org.natuna</td>
<td>launch4j-example</td>
<td>0.0.1</td></tr>
<tr class="b">
<td align="left">org.natuna</td>
<td>launch4j-example</td>
<td>0.0.1</td></tr>
<tr class="a">
<td align="left">org.natuna</td>
<td>launch4j-example</td>
<td>0.0.1</td></tr>
<tr class="b">
<td align="left">org.natuna</td>
<td>launch4j-example</td>
<td>0.0.1</td></tr>
<tr class="a">
<td align="left">org.natuna</td>
<td>launch4j-example</td>
<td>0.0.1</td></tr>
<tr class="b">
<td align="left">org.natuna</td>
<td>launch4j-example</td>
<td>0.0.1</td></tr></table></section><section>
<h2><a name="Project_Report_Plugins"></a>Project Report Plugins</h2><a name="Project_Report_Plugins"></a>
<table border="0" class="table table-striped">
<tr class="a">
<th>GroupId</th>
<th>ArtifactId</th>
<th>Version</th></tr>
<tr class="b">
<td align="left">org.natuna</td>
<td>launch4j-example</td>
<td>0.0.1</td></tr>
<tr class="a">
<td align="left">org.natuna</td>
<td>launch4j-example</td>
<td>0.0.1</td></tr></table></section>

## My Fix

I've created a local version of the plugin that does not cause this problem
by commenting out one line in the ```retrieveBinaryBits()``` method
of the ```Launch4jMojo``` class.

```
    private void retrieveBinaryBits(Artifact a)throws MojoExecutionException{

    ProjectBuildingRequest configuration=session.getProjectBuildingRequest();
    configuration.setRemoteRepositories(project.getRemoteArtifactRepositories());
    configuration.setLocalRepository(localRepository);
    //        configuration.setProject(session.getCurrentProject());

    getLog().debug("Retrieving artifact: "+a+" stored in "+a.getFile());
```


