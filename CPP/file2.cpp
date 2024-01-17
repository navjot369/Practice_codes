#include <iostream>

using namespace std;

class ABC

{

    int *p;

public:
    ABC(int x = 0)

    {

        p = new int(x);
    }

    void setp(int a)

    {

        *p = a;
    }

    void display()

    {

        cout << endl
             << *p;
    }

    ~ABC()

    {

        delete p;
    }

    ABC& operator=(const ABC &temp)

    {

        if (this != &temp)
        {

            *p = *temp.p;
        }

        return *this;
    }
};

int main()

{

    ABC object1(2);

    object1.display();

    ABC object2, object3;

    object2 = object1;

    object1 = object1;

    object2.display();

    object1.setp(3);

    object1.display();

    object2.display();

    return 0;
}