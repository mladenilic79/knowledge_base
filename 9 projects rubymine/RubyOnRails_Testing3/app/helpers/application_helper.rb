module ApplicationHelper

  def application_helper_instance_method
    "i am application helper instance method"
  end

  def self.application_helper_static_method
    "i am application helper static method"
  end

  # various methods
  def various_methods

    # html_safe remove html tags
    "<p>My helper</p>".html_safe

    # using content tags from html in ruby
    content_tag(:div, "my content", class: "my_class")

  end

=begin
  # added button from/for devise
  def login_helper
    if current_user.is_a?(User)
      link_to "Logout", destroy_user_session_path, method: :delete
    else
      # concatinate all for return
      (link_to "Register", new_user_registration_path) +
              (link_to "Login", new_user_session_path)
    end
  end

  def source_helper(layout_name)
    if session[:source]
      "thanks for visiting me from #{session[:source]} and you are on the #{layout_name} layout"
      content_tag(:p, greeting, class: "souurce-greeting")
    end
  end
=end

end
