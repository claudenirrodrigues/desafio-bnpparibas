import { Produto } from "./produto.model";
import { MovimentoManual } from "./movimento-manual.model";

export class ProdutoCosif {

    codigoCosif: string ="";
    produto: Produto;
    codigoClassificacao: string;
    status: string ="";
    movimentosManuais: MovimentoManual[];
}