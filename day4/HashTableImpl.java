package CapgeminiTraining.day4;

/*
    Design an analytics system to track actions performed within an application. The system stores all the actions performed. Once the system has registered a
Store for storage.
specified number of actions, K, it sends them to an Analyfics Actions are represented by an enumeration called ActionEnum. The definition of ActionEnum is provided in the code stub.
Implement the Analytics class with the following specifications:
1. Constructor:
* Analytics (AnalyticsStore analyticsSiore, int K):
Initializes the Analytics class with an AnalyticsSlore object and the value of K.
2. Methods:
* void registerActioh (ActionEnum action): Registers an
action in the application. When the number of registered actions reaches K, call the
storeActions(Queue<ActionEnum> q) method of the AnalyticsStore class. The method takes a Queue containing the K actions in the order they occurred.
* int
getNumberOfAction Registered ButNotSent ToAnalytics
Store 0: Returns the number of actions currently registered in the system but not yet sent to the AnalyticsStore.
* int getTotalNumber fLoggedActions 0: Returns the total number of actions that are currently registered in the system or stored in the AnalyticsStore.
* List<ActionEnum> getMostfrequentiyUsedActions 0:
Out of all the actions registered till now, returns a list of the most frequently performed actions in the application. The list is sorted alphabeticaly based on the string values of the Action Enum entries,
The code stub reads input from the console and call the appropriate functions. The input contains
totalNumber OfRequests and K, followed by the requests.
Each request can be of 4 types,
* register Action X: calls register Action(X)
* getTotalNumber OfloggedActions: calls get TotalNumber OfloggedActions
* getMost Frequently UsedActions.
cals get MostFrequently UsedActions)
* getNumbberOfActionRegisteredBut olSentToAnal ficaSto
re.
calls getNumber OfActionReg
StoreD
steredButNo SentToAnalyDics
Constraints
* 1s totalNumberOfRequests ≤ 105
* 15K≤20
*/
class Node {
    String key;
    int value;
    Node next;

    public Node(String key, int value, Node next) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class HashTableImpl {

}
