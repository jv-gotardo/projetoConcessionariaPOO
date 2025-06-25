package modelo.enums;

public enum TipoCarroceria {
    ABERTA("Aberta"),
    AMBULANCIA("Ambulancia"),
    ATENUADOR_IMPACTO("Atenuador de Impacto"),
    BASCULANTE("Basculante"),
    BLINDADA("Blindada"),
    BOMBEIRO("Bombeiro"),
    BUGGY("Buggy"),
    CABINE_DUPLA("Cabine Dupla"),
    CABINE_ESTENDIDA("Cabine Estendida"),
    CABINE_LINEAR("Cabine Linear"),
    CABINE_ESTENDIDA_LINEAR("Cabine Estendida Linear"),
    CABINE_SUPLEMENTAR("Cabine Suplementar"),
    CABINE_TRIPLA("Cabine Tripla"),
    CHASSI_PORTA_CONTEINER("Chassi Porta-Container"),
    COMBOIO("Comboio"),
    COMERCIO("Comércio"),
    CONVERSIVEL("Conversível"),
    DOLLY("Dolly"),
    FECHADA("Fechada"),
    FUNERAL("Funeral"),
    FURGAO("Furgão"),
    INACABADA("Inacabada"),
    INTERCAMBIAVEL("Intercambiável"),
    JIPE("Jipe"),
    LIMUSINE("Limusine"),
    MECANISMO_OPERACIONAL("Mecanismo Operacional"),
    NENHUMA("Nenhuma"),
    PRANCHA("Prancha"),
    PRANCHA_PORTA_CONTEINER("Prancha Porta-Container"),
    PRANCHA_PORTA_CONTEINER_CARROCERIA_ABERTA("Prancha Porta-Container Carroceria Aberta"),
    ROLL_ON_ROLL_OFF("Roll On Roll Off"),
    SIDECAR("Sidecar"),
    SILO("Silo"),
    SOM("Som"),
    TANQUE("Tanque"),
    TANQUE_PRODUTO_PERIGOSO("Tanque Produto Perigoso"),
    TRAILER("Trailer"),
    TRANSPORTE_CARGA_VIVA("Transporte de Carga Viva"),
    TRANSPORTE_CILINDROS_INTERLIGADOS("Transporte de Cilindros Interligados"),
    TRANSPORTE_ESCOLAR("Transporte Escolar"),
    TRANSPORTE_PRESOS("Transporte de Presos"),
    TRANSPORTE_VALORES("Transporte de Valores"),
    TRANSPORTE_GRANITO("Transporte de Granito"),
    TRANSPORTE_MILITAR("Transporte Militar"),
    TRANSPORTE_RECREATIVO("Transporte Recreativo"),
    TRANSPORTE_MADEIRA_BRUTA("Transporte de Madeira Bruta"),
    TRANSPORTE_TRABALHADOR("Transporte de Trabalhador"),
    TRIO_ELETRICO("Trio Elétrico");
    
    public final String CODIGO;
    
    TipoCarroceria(String codigoString){
        this.CODIGO = codigoString;
    }
}
