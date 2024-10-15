output "app_service_default_hostname" {
  description = "Die Standard-URL der Azure App Service Anwendung"
  value       = azurerm_app_service.app_service.default_site_hostname
}
