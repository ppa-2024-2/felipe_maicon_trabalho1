package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

public interface IRepository<ENTIDADE> { // generics
    
    public ENTIDADE save(ENTIDADE e);

    /**
     * Exclui uma determinada Entidade;
     * 
     * @param e a Entidade a ser excluída.
     * @return true se foi excluída e false caso não.
     */
    public boolean delete(ENTIDADE e);

}
