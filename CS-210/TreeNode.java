public class TreeNode<E> {
    public E data;
    public TreeNode<E> left;
    public TreeNode<E> right;

    public TreeNode(){
        ;
    }
    public TreeNode(E data){
        this.data=data;
    }
    public TreeNode(E data,TreeNode<E> left){
        this.data=data;
        this.left=left;
    }
    public TreeNode(E data,TreeNode<E> left,TreeNode<E> right){
        this.data=data;
        this.left=left;
        this.right=right;
    }
}
