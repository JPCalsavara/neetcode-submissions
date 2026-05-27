/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        // null = -infinito, null = +infinito
        return validate(root, null, null);
    }
 
    // Mudei a ordem para a padrão da reta numérica: (Nó, Mínimo, Máximo)
    public boolean validate(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        // Validações continuam iguais (só mudei a ordem visual para ler melhor)
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        // O PASSE DE BASTÃO:
        // 1. Esquerda: O Mínimo continua sendo o Mínimo atual, o Máximo cai para o valor do pai.
        // 2. Direita: O Mínimo sobe para o valor do pai, o Máximo continua sendo o Máximo atual.
        return validate(root.left, min, root.val) && 
               validate(root.right, root.val, max);
    }
}
