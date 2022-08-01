import com.example.generator.DefaultMybatisPlusGenerator;
import com.example.generator.newtable.entity.Newtable;
import com.example.generator.util.MybatisUtil;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CodeAutoGeneratorTest {
    @Test
    public void generateModuleCodes() {
        // 数据库账号
        String username = "root";
        // 数据库密码
        String password = "root";
        // 数据库名
        String database = "code_auto_genertaor";
        // 文件生成的作者
        String author = "liangliang";
        // 生成的包下面的某个类型的模块，具体的业务模块，里面包含了controller，service，dao，entity等文件夹
        String moduleName = "newtable";
        // 表名
        String[] tableNames = new String[]{
                "newtable",
        };
        // url地址
        String url = "jdbc:mysql://localhost:3306/";
        // 驱动名 根据版本选择驱动
//        String driverName = "com.mysql.cj.jdbc.Driver";
        String driverName = "com.mysql.jdbc.Driver";
        // 包名
        String packageName = "com.example.generator";

        new DefaultMybatisPlusGenerator(database, author, moduleName, tableNames, url, driverName, packageName, username, password)
                // 是否生成Controllers
                .setGenerateControllers(true)
                // 是否生成Services
                .setGenerateServices(true)
                // 是否生成Mappers
                .setGenerateMappers(true)
                // 是否生成XMLs
                .setGenerateXMLs(true)
                // 是否生成Entities
                .setGenerateEntities(true)
                // 是否强制覆盖源文件(如果存在)
                .setFileOverride(true)
                .execute();
    }

    @Test
    public void generateResultMap() {
        // 需要生成resultMap的实体类
//        Newtable a = new Newtable();
        System.err.println(MybatisUtil.getResultMap(Newtable.class));
        //所有属性
        System.out.println(MybatisUtil.getAllField(Newtable.class));
    }

    @Test
    public void test() {
        Duration duration = Duration.between(LocalDateTime.now(),
                LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
        System.out.println(duration.getSeconds());
    }
}
