import { MovimentoManual } from "./movimento-manual.model";
import { ProdutoCosifId } from "./produto-cosif-id.models";

export class ProdutoCosif {

    id: ProdutoCosifId;
    codigoClassificacao: string;
    status: string ="";
    movimentosManuais: MovimentoManual[];
}