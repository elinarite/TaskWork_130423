package TaskWorkHomework2.ITCompany;

import java.util.ArrayList;
import java.util.List;

public class Company {
    /**
     *  1. class Company имя и лист департаментов
     *  2. Энам Департаменты с 5 макисмум департаментами
     *  3. Класс Эплои с полями имя позраст зарплата и рейтинг
     *  4. Энам рейтинг
     *  если рейтинг A то +20%
     *  B +15%
     *  C +5%
     *  D 0%
     *  E -5%
     *  5. Класс генератор который создает Эмплои и засовывет его в рандомный департамент с рандомным рейтингом и зарплатой
     *  Эмплои должен иметьспособность сравниматься по всем полям кроме ретинга
     *  6. Сделать отдельный компаратор который сортирует по рейтингу
     *  7. В классе Мэйн надо прописать только один метод с параметрок количеством сотрудников который с генерирует весь этот процесс и выведет на экран
     * */

    private String companyName;
    List<Department> departmentList = new ArrayList<>();

    public Company(String companyName, List<Department> departmentList) {
        this.companyName = companyName;
        this.departmentList = departmentList;
    }

    public Company(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}