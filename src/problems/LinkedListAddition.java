package problems;

public class LinkedListAddition {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return resultToList(calculateResult(l1, l2));
    }

    public int calculateResult(ListNode l1, ListNode l2){
        if(l1 == null && l2 ==null){
            return 0;
        }

        ListNode firstNumDigit = l1;
        ListNode secondNumDigit = l2;
        int result = 0;
        int multFactor = 1;

        while(firstNumDigit != null && secondNumDigit != null){
            result += (firstNumDigit.val + secondNumDigit.val) * multFactor;
            firstNumDigit = firstNumDigit.next;
            secondNumDigit = secondNumDigit.next;
            multFactor *= 10;
        }

        while(firstNumDigit != null){
            result += firstNumDigit.val * multFactor;
            firstNumDigit = firstNumDigit.next;
            multFactor *= 10;
        }

        while(secondNumDigit != null){
            result += secondNumDigit.val * multFactor;
            secondNumDigit = secondNumDigit.next;
            multFactor *= 10;
        }

        return result;
    }

    public ListNode resultToList(int result){
        if(result ==0){
            return new ListNode(0);
        }

        ListNode retVal = null;
        ListNode current = null;
        ListNode previous = null;
        int currentDigit;
        boolean isHead = true;

        while(result > 0){
            currentDigit = result % 10;
            previous = current;
            current = new ListNode(currentDigit);
            if(isHead){
                retVal = current;
                isHead = false;
            }
            else{
                previous.next = current;
            }
            result = result / 10;
        }

        return retVal;
    }
}

