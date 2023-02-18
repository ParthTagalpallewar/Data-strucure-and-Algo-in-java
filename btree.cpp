#include <iostream>
#include <queue>
using namespace std;

class Node{
private:
	int data;
	Node* left;
	Node* right;
public:
	Node(){
		data = -1;
		left = NULL;
		right = NULL;
	}

	Node(int data){
		this->data = data;
		this->left = NULL;
		this->right = NULL;
	}

    void print(){
        cout << "Left :" << (left == NULL) << " Right: " << (right == NULL) << " Data: " << data << endl;
    }

	friend class BinaryTree;
};

class BinaryTree{
private:
	Node * root;
	queue<Node*> q;

public:

    BinaryTree(){
        this->root = NULL;
    }

	void create(int data){

		Node new_node(data);

		if(root == NULL){
			root = &new_node;
			q.push(root);
		}
    }

    void insert(){


        while (q.empty() == false)
        {


            Node *parent;
            parent = q.front();
            q.pop();

            cout << "Do you want to insert in left of " << parent->data << endl;
            char ans;
            cin >> ans;

            if (ans == 'y')
            {

                cout << "Enter Data you want to insert " << endl;
                int data;
                cin >> data;

                Node left_node(data);
                parent->left = &left_node;
                q.push(&left_node);
            }

            cout << "Do you want to insert in right of " << parent->data << endl;
            cin >> ans;

            if (ans == 'y')
            {

                cout << "Enter Data you want to insert " << endl;
                int data;
                cin >> data;

                Node right_node(data);
                parent->right = &right_node;
                q.push(&right_node);
            }
        }
    }

	Node* get_root(){
		return root;
	}

	void in_order(Node *node){

        node->print();


		if(node == NULL) return;

		in_order(node->left);
        cout << node->data << " " << endl;
        in_order(node->right);

    }


};

int main(){

    BinaryTree tree;

    tree.create(10);
    
    tree.in_order(tree.get_root());

    return 0;
}

