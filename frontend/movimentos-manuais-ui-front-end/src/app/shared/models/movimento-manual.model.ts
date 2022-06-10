import { ProdutoCosif } from "./produto-cosif.model";

export class MovimentoManual {
    numeroLancamento: number;
    mes: number;
    ano: number;
    produtoCosif: ProdutoCosif;
    descricao: string;
    dataMovimento: Date;
    codigoUsuario: string = UserDefault.USUARIO_TESTE;
    valor: number;

}

export const UserDefault = {USUARIO_TESTE: 'TESTE'};