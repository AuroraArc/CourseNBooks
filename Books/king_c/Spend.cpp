//
// Created by Henry Yu on 2/15/24.
//

#include <vector>
#include <string>

struct itemT {
    std::string name;
    double price;
    int count;
};

bool spendAllHelper(double amount, std::vector<itemT>& inventory, int index) {
    // Base case: if amount is 0, we have found a solution
    if (amount == 0) {
        return true;
    }

    // Base case: if we have exhausted all items and still haven't found a solution
    if (index == inventory.size()) {
        return false;
    }

    // Recursive case: try to include the current item in the basket
    if (inventory[index].count > 0 && inventory[index].price <= amount) {
        inventory[index].count--;
        if (spendAllHelper(amount - inventory[index].price, inventory, index)) {
            return true;
        }
        inventory[index].count++; // backtrack
    }

    // Recursive case: move to the next item
    return spendAllHelper(amount, inventory, index + 1);
}

bool spendAll(double amount, std::vector<itemT>& inventory) {
    return spendAllHelper(amount, inventory, 0);
}
