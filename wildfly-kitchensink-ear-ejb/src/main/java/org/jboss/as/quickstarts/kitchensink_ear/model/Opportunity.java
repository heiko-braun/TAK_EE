package org.jboss.as.quickstarts.kitchensink_ear.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.util.Collection;

/**
 * @author Heiko Braun
 * @since 03/09/15
 */
@Entity
@XmlRootElement
@Table(name = "Opportunity")
public class Opportunity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private java.sql.Date dateStart;

    @NotNull
    private java.sql.Date dateEnd;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="STATUS_ID")
    private OpportunityStatus status;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="ACTIVITY_ID")
    private Activity activity;

    @ManyToMany(targetEntity=Member.class, fetch = FetchType.EAGER)
    @JoinTable(name="Opportunity_Member",
            joinColumns=
            @JoinColumn(name="OP_ID", referencedColumnName="ID"),
            inverseJoinColumns=
            @JoinColumn(name="MEM_ID", referencedColumnName="ID")
    )
    private Collection<Member> participants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public OpportunityStatus getStatus() {
        return status;
    }

    public void setStatus(OpportunityStatus status) {
        this.status = status;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Collection<Member> getParticipants() {
        return participants;
    }

    public void setParticipants(Collection<Member> participants) {
        this.participants = participants;
    }
}
