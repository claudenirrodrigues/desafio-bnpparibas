import { ProdutoCosif } from "./produto-cosif.model";

export class MovimentoManual {
    numeroLancamento: number;
    mes: number;
    ano: number;
    produtoCosif: ProdutoCosif;
    descricao: string;
    dataMovimento: Date;
    codigoUsuario: string;
    valor: number;
    
    //constructor(produtoCosif: ProdutoCosif) {
    //    this.produtoCosif = produtoCosif;
    //}


}

export const UserDefault = {USUARIO_TESTE: 'TESTE'};