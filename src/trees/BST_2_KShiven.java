package trees;


import java.util.ArrayList;

public class BST_2_KShiven <E extends Comparable<E>> {

    private class BSTNode<E> {
        private BSTNode<E> left, right;
        private E value;

        public BSTNode(E value) {
            this.value = value;
        }

        public BSTNode<E> getLeftNode() {
            return this.left;
        }

        public BSTNode<E> getRightNode() {
            return this.right;
        }

        public E getValue() {
            return this.value;
        }

        public void setLeftNode(BSTNode<E> node) {
            this.left = node;
        }

        public void setRightNode(BSTNode<E> node) {
            this.right = node;
        }

        public void setValue(E value) {
            this.value = value;
        }


    }

    private BSTNode<E> root;

    public BST_2_KShiven() {

    }

    public boolean search(E value) {
        BSTNode<E> current = root;


        while (current != null) {

            if (value.compareTo(current.getValue()) == 0) {
                return true;
            } else if (value.compareTo(current.getValue()) < 0) {
                current = current.getLeftNode();
            } else if (value.compareTo(current.getValue()) > 0) {
                current = current.getRightNode();
            }
        }

        return false;


    }

    public boolean add(E value) {
        BSTNode<E> current = root;

        if (current == null) {
            this.root = new BSTNode<>(value);
            return true;
        }

//        while (current != null) {
//            parent = current;
//            if (value.compareTo(current.getValue()) < 0) {
//                current = current.getLeftNode();
//                if (current.getLeftNode() == null) {
//                    parent.setLeftNode(new BSTNode<>(value));
//                    return true;
//                }
//            } else if (value.compareTo(current.getValue()) > 0) {
//                current = current.getRightNode();
//                if (current.getRightNode() == null) {
//                    parent.setRightNode(new BSTNode<>(value));
//                    return true;
//                }
//            }
//        }
        while (current != null) {
            int c = value.compareTo(current.getValue());

            if (c < 0) {
                if (current.getLeftNode() == null) {
                    current.setLeftNode(new BSTNode<>(value));
                    return true;
                }
                current = current.getLeftNode();
            } else if (c > 0) {
                if (current.getRightNode() == null) {
                    current.setRightNode(new BSTNode<>(value));
                    return true;
                }
                current = current.getRightNode();
            } else {
                return false;
            }
        }


        return false;
    }
    // preorder, inorder, postorder, recursive
    // preorder -> left right root
    // inorder -> left root right
    // root left right

    public ArrayList<E> preorder(BSTNode<E> subroot) {
        ArrayList<E> pre = new ArrayList<>();

        if (subroot == null) return pre;

//        pre.add(subroot.getValue());
//
//        ArrayList<E> left = preorder(subroot.getLeftNode());
//        pre.addAll(left);
//
//        ArrayList<E> right = preorder(subroot.getRightNode());
//        pre.addAll(right);

        // pre.addAll(preorder(subroot.getLeftNode());
        // pre.addAll(preorder(subroot.getRightNode());
        pre.add(subroot.getValue());
        pre.addAll(preorder(subroot.getLeftNode()));
        pre.addAll(preorder(subroot.getRightNode()));


        return pre;
    }

    public ArrayList<E> inOrder(BSTNode<E> subroot) {
        ArrayList<E> in = new ArrayList<>();

        if (subroot == null) return in;

//        pre.add(subroot.getValue());
//
//        ArrayList<E> left = preorder(subroot.getLeftNode());
//        pre.addAll(left);
//
//        ArrayList<E> right = preorder(subroot.getRightNode());
//        pre.addAll(right);

        // pre.addAll(preorder(subroot.getLeftNode());
        // pre.addAll(preorder(subroot.getRightNode());
        in.addAll(preorder(subroot.getLeftNode()));
        in.add(subroot.getValue());
        in.addAll(preorder(subroot.getRightNode()));

        return in;
    }

    public ArrayList<E> postOrder(BSTNode<E> subroot) {
        ArrayList<E> post = new ArrayList<>();

        if (subroot == null) return post;

//        pre.add(subroot.getValue());
//
//        ArrayList<E> left = preorder(subroot.getLeftNode());
//        pre.addAll(left);
//
//        ArrayList<E> right = preorder(subroot.getRightNode());
//        pre.addAll(right);

        // pre.addAll(preorder(subroot.getLeftNode());
        // pre.addAll(preorder(subroot.getRightNode());
        post.addAll(preorder(subroot.getLeftNode()));
        post.addAll(preorder(subroot.getRightNode()));
        post.add(subroot.getValue());

        return post;
    }

    public BSTNode<E> getRoot() {
        return root;
    }

    public int height() {
        return 1 + Math.max(height(root.getLeftNode()), height(root.getRightNode()));
    }

    public int height(BSTNode<E> subroot) {
        return (subroot == null) ? -1 : 1 + Math.max(height(subroot.getLeftNode()), height(subroot.getRightNode()));

        // lowk forgot about ternary operators, how to do ?
        // if (statement) ? do this : else that? or is it the other wa
        // return a ? b : c, right
        // its right!
    }

    public int depth(E value) {
        // amount of connections you need to get form the root to a specific node


        int d = 0;
        BSTNode<E> current = root;
        while (current != null) {
            int compare = value.compareTo(current.getValue());

            if (compare < 0) {
                d++;
                current = current.getLeftNode();
            } else if (compare > 0) {
                d++;
                current = current.getRightNode();
            } else {
                return d;
            }
        }
        return -1;
    }

    public boolean delete(E value) {
        BSTNode<E> parent = null;
        BSTNode<E> current = root;

        while (current != null) {
            int c = value.compareTo(current.getValue());

            if (c < 0) {
                parent = current;
                current = current.getLeftNode();
            } else if (c > 0) {
                parent = current;
                current = current.getRightNode();
            } else if (c == 0) {
                break;
            }
        }

        if (current == null) {
            return false;
        }

        if (current.getLeftNode() == null && current.getRightNode() == null) {
            if (current == root) {
                root = null;
            }
            if (parent.getLeftNode() == current) {
                parent.setLeftNode(null);
            } else {
                parent.setRightNode(null);

            }
            return true;
        }

        if (current.getLeftNode() == null || current.getRightNode() == null) {
            BSTNode<E> child;

            if (current.getLeftNode() != null) {
                child = current.getLeftNode();
            } else {
                child = current.getRightNode();
            }

            if (current == root) {
                root = child;
            }

            if (parent.getLeftNode() == null) {
                parent.setRightNode(child);
            } else {
                parent.setLeftNode(child);
            }
            return true;
        }

        BSTNode<E> sucessor = current;
        BSTNode<E> s_parent = null;

        sucessor = sucessor.getRightNode();
        while (sucessor != null) {
            s_parent = sucessor;
            sucessor = sucessor.getLeftNode();
        }
        current.setValue(sucessor.getValue());

        if (s_parent.getLeftNode() == sucessor) {
            s_parent.setRightNode(sucessor.getRightNode());
        } else {
            s_parent.setLeftNode(sucessor.getRightNode());
        }
        return true;
    }
}

