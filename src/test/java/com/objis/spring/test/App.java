package com.objis.spring.test;

import com.objis.spring.demodao.IFormationDao;
import com.objis.spring.demodomaine.Formation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {

    private Formation form;
    private IFormationDao springDao;
    private ClassPathXmlApplicationContext appContext;

    /**
     * Initialisation du contexte Spring et du bean du Dao.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        form = new Formation(1, "GTM");
        appContext = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/application-servlet.xml");
        springDao = (IFormationDao) appContext.getBean("IFormationDao");
    }

    /**
     * Sauvegarde du bean par l’interface Repository de Spring Data
     */
    @Test
    public void saveFormation() {
        Formation result = springDao.save(form);
        System.out.println("Formation ajoutée en base : " + result.toString());
    }

    /**
     * Affichage des éléments en base
     */
    @Test
    public void testListFormation() {
        springDao = (IFormationDao) appContext.getBean("IFormationDao");
        List<Formation> formation = springDao.findByThemeContaining(form.getTheme());
        for (Formation e : formation) {
            System.out.println(e.getTheme());
        }
        Assert.assertNotNull(formation);
    }
}

