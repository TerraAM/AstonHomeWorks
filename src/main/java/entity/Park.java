package main.java.entity; //Определяют пакет, в котором находится файл

/*Блок с подключением необходимых ресурсов*/
import java.math.BigDecimal;
import java.util.ArrayList; 
import java.util.List;

/*Класс описывающий парк*/
public class Park {
	
	/*Блок приватных полей класса*/
	private String name;//Название
	private String location;//Место расположения
	private List<Attraction> attractions;//Аттракционы

	/*Пустой конструктор*/
    public Park() {
    }
    
    /*Конструктор с передачей значений для полей класса*/
    public Park(String name, String location) {
        this.name = name;//Указываем при помощи this., что параметру Этого класса присваиваеи значение передаваемой переменной
        this.location = location;
        this.attractions = new ArrayList<>();//Инициализация пустого списка
    }
    
    /*Метод для добавления аттракциона к списку парка*/
    public void addAttraction(String attractionName, String workingHours, BigDecimal price) {
        attractions.add(new Attraction(attractionName, workingHours, price));//Добавления к списку List нового объекта класса Attraction
    }
    
    /*Переопределяем метод класса-родителя Object,
	 * тем самым редактируя вывод этого класса в виде строки*/
    @Override
    public String toString() {
        return "Park{" +
                "name='" + name + '\'' +//Для того, что бы закрыть(при помощи " ' ") поле с информацией (прим.: ...email='olga.smirnova@mail.com'...), можно написать "'" или '\''
                ", location='" + location + '\'' +
                ", attractions='" + attractions + '\'' +
                '}';
    }

    /*Внутренний класс описывающий аттракцион*/
    public class Attraction {
    	
    	/*Блок приватных полей класса*/
        private String attractionName;//Название
        private String workingHours;//Часы работы
        private BigDecimal price;//Стоимость

        /*Пустой конструктор*/
        public Attraction() {
        }

        /*Конструктор с передачей значений для всех полей класса*/
        public Attraction(String attractionName, String workingHours, BigDecimal price) {
            this.attractionName = attractionName;//Указываем при помощи this., что параметру Этого класса присваиваеи значение передаваемой переменной
            this.workingHours = workingHours;
            this.price = price;
        }

        /*Переопределяем метод класса-родителя Object,
    	 * тем самым редактируя вывод этого класса в виде строки*/
        @Override
        public String toString() {
            return "\nAttraction{" +
                    "attractionName='" + attractionName + '\'' +//Для того, что бы закрыть(при помощи " ' ") поле с информацией (прим.: ...email='olga.smirnova@mail.com'...), можно написать "'" или '\''
                    ", workingHours='" + workingHours + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
