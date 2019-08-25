package design_pattern.zen_of_design_pattern.chapter20;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * iterator design pattern
 */
public class Boss {
    public static void main(String[] args) {
        IProject project = new Project();

        project.add("星球大战项目", 10, 100000);

        project.add("扭转时空项目", 100, 100000000);

        project.add("超人改造项目", 1000, 100000000);

        for (int i = 4; i < 104; i++) {
            project.add("第" + i + "个项目", i * 5, i * 100000000);
        }

        IProjectIterator projectIterator = (IProjectIterator) project.iterator();
        while (projectIterator.hasNext()) {
            IProject p = (IProject) projectIterator.next();
            System.out.println(p.getProjectInfo());
        }

        ArrayList list = new ArrayList();
        Iterator it = list.iterator();

    }
}
