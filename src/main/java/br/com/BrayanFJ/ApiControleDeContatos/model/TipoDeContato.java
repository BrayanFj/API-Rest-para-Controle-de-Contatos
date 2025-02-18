package br.com.BrayanFJ.ApiControleDeContatos.model;

public enum TipoDeContato {
    TELEFONE(0),
    CELULAR(1),
    EMAIL(2),
    LINKEDIN(3),
    GITHUB(4);

    private final int codigo;

    TipoDeContato(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static TipoDeContato fromCodigo(int codigo) {
        try {
            for (TipoDeContato tipo : TipoDeContato.values()) {
                if (tipo.getCodigo() == codigo) {
                    return tipo;
                }
            }
            throw new IllegalArgumentException("Código inválido! Não existe tipo de contato com código: " + codigo);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: Código inválido para TipoDeContato! Código fornecido: " + codigo
                    + ". Valores válidos são: 0 (TELEFONE), 1 (CELULAR), 2 (EMAIL), 3 (LINKEDIN), 4 (GITHUB).");

            throw e;
        }
    }
}
