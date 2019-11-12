=begin
# concern are used for some extra data functionality

# in rails module name & file name must match
module DeviseWhitelist
    # default extend for concern
    extend Active::Concern

    included do
        # before_filter (same as before_action) - run this before any & all other controllers
        before_filter :configure_permitted_parameters, if: :devise_controller?
    end

    def configure_permitted_parameters
        devise_parameter_sanitizer.permit(:sign_up, keys: [:name])
        devise_parameter_sanitizer.permit(:account_update, keys: [:name])
    end
end
=end
