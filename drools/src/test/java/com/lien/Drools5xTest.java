package com.lien;

import com.lien.drools.model.Product;
import org.drools.core.marshalling.impl.ProtobufMessages;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import java.util.Collection;

/**
 * Description: <br>
 *
 * @author li
 * @date 2018/10/16 下午5:36
 */
public class Drools5xTest {

    public static void main(String[] args) {
        Drools5xTest test = new Drools5xTest();
        test.oldExecuteDrools();
    }
    private void oldExecuteDrools() {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("com/rules/Rules.drl",
                this.getClass()), ResourceType.DRL);
        if (kbuilder.hasErrors()) {
            System.out.println(kbuilder.getErrors().toString());
        }
        Collection<KnowledgePackage> pkgs = kbuilder.getKnowledgePackages();
        // add the package to a rulebase
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        // 将KnowledgePackage集合添加到KnowledgeBase当中
        kbase.addKnowledgePackages(pkgs);
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        Product product = new Product();
        product.setType(Product.GOLD);
        ksession.insert(product);
        ksession.fireAllRules();
        ksession.dispose();
        System.out.println("The discount for the product " + product.getType()
                + " is " + product.getDiscount()+"%");
    }

}
