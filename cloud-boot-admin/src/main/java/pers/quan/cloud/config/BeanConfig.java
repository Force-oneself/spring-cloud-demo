package pers.quan.cloud.config;

import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.notify.RemindingNotifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import pers.quan.cloud.util.DingDingNotifier;

import java.time.Duration;

/**
 * @Description:
 * @Author heyq
 * @Date 2021-02-28
 **/
@Configuration
public class BeanConfig {

    @Bean
    public DingDingNotifier dingDingNotifier(InstanceRepository repository) {
        return new DingDingNotifier(repository);
    }

    /**
     * 循环发送多条警报,比如十秒发送一次
     * @param repository
     * @return
     */
    @Primary
    @Bean(initMethod = "start", destroyMethod = "stop")
    public RemindingNotifier remindingNotifier(InstanceRepository repository) {
        RemindingNotifier notifier = new RemindingNotifier(dingDingNotifier(repository), repository);
        notifier.setReminderPeriod(Duration.ofSeconds(10));
        notifier.setCheckReminderInverval(Duration.ofSeconds(10));
        return notifier;
    }
}
