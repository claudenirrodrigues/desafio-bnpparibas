import { MovimentoManualId } from "./movimento-manual-id.models";

export class MovimentoManual {
    id: MovimentoManualId;
    descricao: string;
    dataMovimento: Date;
    codigoUsuario: string;
    valor: number;
    
    //constructor(produtoCosif: ProdutoCosif) {
    //    this.produtoCosif = produtoCosif;
    //}


}

export const UserDefault = {USUARIO_TESTE: 'TESTE'};