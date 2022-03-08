package br.com.tech4me.dto;

public class LivroDTO {
    private String id;
    private String titulo;
    private String autor;
    private String editora;
    private Integer anoLancamento;
    private Double valor;
    private Double precoCusto;
    private Double margemLucro;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public Integer getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Double getPrecoCusto() {
        return precoCusto;
    }
    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }
    public Double getMargemLucro() {
        return margemLucro;
    }
    public void setMargemLucro(Double margemLucro) {
        this.margemLucro = margemLucro;
    }

    
    
}
