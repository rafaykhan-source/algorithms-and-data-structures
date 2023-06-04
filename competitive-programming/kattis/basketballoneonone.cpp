#include <iostream>

using namespace std;

int main() {
    int aScore = 0;
    int bScore = 0;
    string input;
    getline(cin, input);
    
    for (int i = 0; i < input.size(); i += 2) {
        if (input[i] == 'A') {
            aScore += (int) input[i+1];
        } else {
            aScore += (int) input[i+1];
        }
    }
}