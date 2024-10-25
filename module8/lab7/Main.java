package Modules.module8.lab7;

///Beverage негізгі классында шаблондық әдіс болып табылатын prepare Recipe () әдісі бар.
// Ол сусын дайындау қадамдарының реттілігін анықтайды. Кейбір қадамдар барлық сусындарға ортақ,
// басқалары белгілі бір сусынға байланысты (мысалы, қайнату және ингредиенттерді қосу.
//Tea және Coffee мұрагерлік класстар ингредиенттерді қайнату және қосу процесі сияқты нақты қадамдарды орындайды.

////Шаблонный метод-нақты қадамдарды өзгерту мүмкіндігімен жалпы алгоритм құруға мүмкіндік береді.
public class Main {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        System.out.println("Making tea:");
        tea.prepareRecipe();

        System.out.println();

        Beverage coffee = new Coffee();
        System.out.println("Making coffee:");
        coffee.prepareRecipe();

        System.out.println();

        Beverage hotChoco = new HotChocolate();
        System.out.println("Making hot chocolate:");
        hotChoco.prepareRecipe();
    }
}
