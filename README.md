# demoSpringV5

JAVA : JRE /JDK / JSE (J2SE)

J2EE : JSP / Servelet / JPA

Spring framework / Context

Spring : inversion des new() avec la notion de dépendance DAO depend du service qui depend de la présentation


Strucure du projet :
	- Web.xml (src/main/webapp/web-inf/)
Dans le pom:
	- changer le packaging en WAR
	- dependances : spring-context (5.1.5 RELEASE) / spring-webmvn (5.1.5 RELEASE) / javax.servlet (1.2)

Serveur -> appweb -> servlet (spring web) -> JSP -> Client -->  (HTTP) --> Serveur


parametrer le web.xml 
	- balise servlet : name(nom), class (dispatcherservelet)
	- balise servlet-mapping : name (nom), url-pattern (/)

Configuration de spring:
	- application-servelet.xml dans webapp/web-inf
	- ajouter en entete xmlns:mvn
	- ajouter balise <mvn:annoation-driven/>
	- ajouter bean viewResolver
		- prefix
		- suffix
		- viewClass

Creer page JSP dans le repertoire (webapp\WEB-INF\views)

ajouter dans le fichier de configuration de spring :
<context:component-scan base-package="" />

creer appController.java
	- ajouter annotation @controller sur la class
	- ajouter : public ModelAndView index() puis ajouter l'annotation @RequestMapping("/")

Dans index.jsp:
	-ajouter entete imoort taglib JSTL core
	- code
	- remplacer la liste en dure par l'appel au DAO
	- en dessous du titre ajouter un lien href vers "form.html"

Dans appController:
	- ajouter la methode show form() avec annotation "RequestMapping"
	- configurer vers ModelAndView vers la vue "form"

Dans views, ajouter form.jsp

Dans form.jsp :
	- sur form method = "post"

Dans le controller:
	- ajouter validateForm(int id, string theme) avec annotation @RequestMapping(path = "/form", method = RequestMethod.POST)
	- construire un nouvelle objet
	- appeler this.formationDAO.save()
	- return this.index

Ajouter package service
	- class formationService
	- Annotation @service
	- dependance a formationDao
	- methode getAll()
	- methode create()

Dans appcontroller
	- remplacer les utilisations du DAO par le service


Catalina : webservice
Jasper: JSP
Coyote: http

Ajouter une page de recherche:
	- Presentation : Nouvelle JSP <=search.html=>AppController
	- metier : nouvelle methode dans le service 
		-> decouper les mots cleds de recherche par espace ou tiret
		-> pour chaque mot, appeler le DAO pour chercher en BDD
	- DAO : changer la methode en findByThemeContaining()

elvynia@gmail.com
