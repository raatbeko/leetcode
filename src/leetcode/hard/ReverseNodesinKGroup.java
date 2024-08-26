package leetcode.hard;

public class ReverseNodesinKGroup {

    // Метод для реверсирования узлов в списке на промежутке [start, end).
    // Возвращает новую голову реверсированного списка.
    private static String reverseList() {
//        ListNode prev = null;
//        ListNode current = start;
//        ListNode next = null;
//        while (current != null) {
//            next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
//        return prev; // Новая голова реверсированного списка.
        return null;
    }

    public static String reverseKGroup() {
//        if (head == null || k == 1) {
//            return head;
//        }
//
//        // Создаём фиктивный узел, который будет указывать на начало списка.
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//
//        // Предыдущий узел перед группой, которую собираемся реверсировать.
//        ListNode prevGroupEnd = dummy;
//
//        // Переменная для итерации по списку.
//        ListNode current = head;
//
//        while (current != null) {
//            // Определяем конец текущей группы.
//            ListNode end = current;
//            for (int i = 1; i < k && end != null; i++) {
//                end = end.next;
//            }
//            // Если достигнут конец списка до полного набора группы, выходим.
//            if (end == null) break;
//
//            // Сохраняем начало следующей группы.
//            ListNode nextGroupStart = end.next;
//
//            // Отсоединяем текущую группу от следующей, чтобы избежать циклических ссылок при реверсе.
//            end.next = null;
//
//            // Реверсируем текущую группу.
//            ListNode newGroupHead = reverseList(current);
//
//            // Соединяем предыдущую группу с новой головой текущей группы.
//            prevGroupEnd.next = newGroupHead;
//
//            // Обновляем 'prevGroupEnd' для текущей группы.
//            prevGroupEnd = current;
//
//            // Соединяем конец текущей группы (старая голова) с началом следующей группы.
//            current.next = nextGroupStart;
//
//            // Перемещаем 'current' к началу следующей группы.
//            current = nextGroupStart;
//        }

        // Возвращаем новую голову списка, которая теперь следует за фиктивным узлом.
        return null;
    }

    public static void main(String[] args) {
//        // Создаем список: 1 -> 2 -> 3 -> 4 -> 5
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);
//        head.next.next.next.next.next.next.next.next = new ListNode(9);
//        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
//
//        head = reverseKGroup(head, 2);
//
//        // Печатаем реверсированный список
//        while (head != null) {
//            System.out.print(head.val + " ");
//            head = head.next;
//        }
    }

}
