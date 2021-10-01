cp target/simple-tax-plugin-1.0.0-SNAPSHOT.jar /var/lib/killbill/bundles/plugins/java/simple-tax-plugin/1.0.0-SNAPSHOT/
sudo find /var/lib/killbill/bundles/plugins/java -type d -exec sudo chown tomcat {} \;
sudo systemctl restart killbill