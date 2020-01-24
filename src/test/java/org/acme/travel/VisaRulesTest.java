package org.acme.travel;

import java.util.Date;

import javax.inject.Inject;

import io.quarkus.test.junit.QuarkusTest;
import org.acme.travel.Address;
import org.acme.travel.Traveller;
import org.acme.travel.Trip;
import org.drools.core.common.InternalAgenda;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieSession;
import org.kie.kogito.rules.KieRuntimeBuilder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class VisaRulesTest {

    @Inject
    KieRuntimeBuilder ruleRuntime;

    @Test
    public void testVisaNotRequiredRule() {

        assertNotNull(ruleRuntime);

        Traveller traveller = new Traveller("John", "Doe", "john.doe@example.com", "American", new Address("main street", "Boston", "10005", "US"));
        Trip trip = new Trip("New York", "US", new Date(), new Date());

        KieSession ksession = ruleRuntime.newKieSession();
        ((InternalAgenda) ksession.getAgenda()).activateRuleFlowGroup("visas");
        ksession.insert(trip);
        ksession.insert(traveller);
        ksession.fireAllRules();

        ksession.dispose();

        assertFalse(trip.isVisaRequired());
    }

    @Test
    public void testVisaRequiredRule() {

        assertNotNull(ruleRuntime);

        Traveller traveller = new Traveller("Jan", "Kowalski", "jan.kowalski@example.com", "Polish", new Address("polna", "Krakow", "32000", "Poland"));
        Trip trip = new Trip("New York", "US", new Date(), new Date());

        KieSession ksession = ruleRuntime.newKieSession();
        ((InternalAgenda) ksession.getAgenda()).activateRuleFlowGroup("visas");
        ksession.insert(trip);
        ksession.insert(traveller);
        ksession.fireAllRules();

        ksession.dispose();

        assertTrue(trip.isVisaRequired());
    }
}
