/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.pcamacho.model.dao;

import utng.pcamacho.model.pojos.Libros;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;

/**
 *
 * @author gerar
 */
public class LibrosDAO {
    public void ingresarLibros(Libros l){
        SessionFactory sf=null;
        Session sesion=null;
        Transaction tx=null;
        try {
            sf=HibernateUtil.getSessionFactory();
            sesion=sf.openSession();
            tx=sesion.beginTransaction();
            sesion.save(l);
            tx.commit();
            sesion.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo guardar el libro");
        }
    }
    
    public String consultarLibros(int codigo){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Libros l=(Libros)sesion.get(Libros.class, codigo);
        sesion.close();
        if(l!=null){
            return "Titulo: "+l.getTitulo()+
                    "  Autor: "+l.getAutor()+"  Editorial: "+l.getEditorial()+"   Edicion: "+l.getEdicion();
        }else{
            return "El libro de codigo "+codigo+" no exite";
        }
    }
    
    public List<Libros> verLibros(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Query query = sesion.createQuery("from Libros");
        List<Libros> lista = query.list();
        sesion.close();
        return lista;
    }
}
