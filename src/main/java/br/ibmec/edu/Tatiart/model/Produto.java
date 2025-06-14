package br.ibmec.edu.Tatiart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O nome do produto é obrigatório")
    private String nome;
    
    @Column(columnDefinition = "TEXT")
    private String head;
    
    @Column(columnDefinition = "TEXT")
    private String header;
    
    @Column(columnDefinition = "TEXT")
    private String heroSection;
    
    @Column(columnDefinition = "TEXT")
    private String galeriaSection;
    
    @Column(columnDefinition = "TEXT")
    private String featuresSection;
    
    @Column(columnDefinition = "TEXT")
    private String depoimentosSection;
    
    @Column(columnDefinition = "TEXT")
    private String personalizacaoSection;
    
    @Column(columnDefinition = "TEXT")
    private String comoFuncionaSection;
    
    @Column(columnDefinition = "TEXT")
    private String tiposPersonalizacaoSection;
    
    @Column(columnDefinition = "TEXT")
    private String ctaSection;
    
    @Column(columnDefinition = "TEXT")
    private String footer;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeroSection() {
        return heroSection;
    }

    public void setHeroSection(String heroSection) {
        this.heroSection = heroSection;
    }

    public String getGaleriaSection() {
        return galeriaSection;
    }

    public void setGaleriaSection(String galeriaSection) {
        this.galeriaSection = galeriaSection;
    }

    public String getFeaturesSection() {
        return featuresSection;
    }

    public void setFeaturesSection(String featuresSection) {
        this.featuresSection = featuresSection;
    }

    public String getDepoimentosSection() {
        return depoimentosSection;
    }

    public void setDepoimentosSection(String depoimentosSection) {
        this.depoimentosSection = depoimentosSection;
    }

    public String getPersonalizacaoSection() {
        return personalizacaoSection;
    }

    public void setPersonalizacaoSection(String personalizacaoSection) {
        this.personalizacaoSection = personalizacaoSection;
    }

    public String getComoFuncionaSection() {
        return comoFuncionaSection;
    }

    public void setComoFuncionaSection(String comoFuncionaSection) {
        this.comoFuncionaSection = comoFuncionaSection;
    }

    public String getTiposPersonalizacaoSection() {
        return tiposPersonalizacaoSection;
    }

    public void setTiposPersonalizacaoSection(String tiposPersonalizacaoSection) {
        this.tiposPersonalizacaoSection = tiposPersonalizacaoSection;
    }

    public String getCtaSection() {
        return ctaSection;
    }

    public void setCtaSection(String ctaSection) {
        this.ctaSection = ctaSection;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }
} 