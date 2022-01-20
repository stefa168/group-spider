package stefa168.group_spider.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "telegram_user")
public class TelegramUser {
    @Positive
    @NotNull
    @Id
    @Column(name = "telegram_id", nullable = false)
    private Long telegramID;

    @Positive
    @NotNull
    @Column(name = "last_message_date", nullable = false)
    private Long lastMessageDate;

    @Column(name = "full_name", length = 128, nullable = false)
    private String fullName;

    @Column(name = "username", length = 32)
    private String username;

    public TelegramUser(Long telegramID, Long lastMessageDate, String fullName, String userName) {
        this.telegramID = telegramID;
        this.lastMessageDate = lastMessageDate;
        this.fullName = fullName;
        this.username = userName;
    }

    public TelegramUser() {
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getFullName() {return fullName;}

    public void setFullName(String fullName) {this.fullName = fullName;}

    public Long getLastMessageDate() {return lastMessageDate;}

    public void setLastMessageDate(Long lastMessageDate) {this.lastMessageDate = lastMessageDate;}

    public Long getTelegramID() {return telegramID;}

    public void setTelegramID(Long id) {this.telegramID = id;}

}