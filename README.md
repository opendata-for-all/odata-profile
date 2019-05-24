Eclipse plugin for OData
========

An Eclipse plugin including:

* An editor based on [Papyrus](https://eclipse.org/papyrus/ "Papyrus") allowing the annotation of UML class diagrams with OData stereotypes.
* A generator to apply an OData profile to any UML model.

## Requirements
- Eclipse Modeling tools (it can be found [here](http://www.eclipse.org/downloads/packages/eclipse-modeling-tools/oxygen2)).
- [Papyrus](https://www.eclipse.org/papyrus/) (check the instructions on how to install it [here](http://www.eclipse.org/papyrus/download.html)).

## Installation
1. Open Eclipse IDE
2. Click on *Help / Install New Software...*
3. Click on *Add...* and fill in the form as indicated (the update site is https://opendata-for-all.github.io/odata-profile/updates/oxygen) then click on *OK*.

![Add repository](https://opendata-for-all.github.io/odata-profile/images/add.PNG)

4. Select *OData* then click on *Next*.

![Install](https://opendata-for-all.github.io/odata-profile/images/install.PNG)

5. Follow the the rest of the steps (license, etc...) and reboot Eclipse.

## Using the plugin

# Auto-apply the profile
1. Create a Project or use an existing project in your workspace.
2. Create or import a UML model (you can use our [UML model](https://opendata-for-all.github.io/odata-profile/resources/products.uml)).
3. To auto-apply the profile: Right-click on your model and select *OData/Auto-apply profile*. This will annotate your UML model with OData stereotypes (check the annotated UML model [here](https://opendata-for-all.github.io/odata-profile/resources/annotated-products.uml)).

# Manually apply the profile using Papyrus
1. Create a Project or use an existing project in your workspace.
2. Create a Papyrus model (Check *Class Diagram* in the wizard).
3. Once your diagram editor is opened, click on the *Properties* view (just below the canvas), click on the *Profile* tab, click on *Apply registered profile*, then choose the OData profile as shown below.

![profile](https://opendata-for-all.github.io/odata-profile/images/odata-profile-view.PNG)

4. Check *ODataProfile* then click on *OK*.

![profile](https://opendata-for-all.github.io/odata-profile/images/choose.PNG)

4. Use the *Profile* tab to apply stereotypes on your UML elements (see the example below).

![screenshot](https://opendata-for-all.github.io/odata-profile/images/screenshot.PNG)

Who is behind this?
-----------------------
* [Hamza Ed-douibi](http://github.com/hamzaed/ "Hamza Ed-douibi")
* [Javier Canovas](http://github.com/jlcanovas/ "Javier Canovas")
* [Jordi Cabot](http://github.com/jcabot/ "Jordi Cabot")



